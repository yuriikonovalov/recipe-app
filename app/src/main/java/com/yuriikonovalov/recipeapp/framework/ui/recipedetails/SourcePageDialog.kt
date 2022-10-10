package com.yuriikonovalov.recipeapp.framework.ui.recipedetails

import android.content.*
import android.graphics.Bitmap
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.core.view.isGone
import androidx.fragment.app.DialogFragment
import androidx.navigation.fragment.navArgs
import com.yuriikonovalov.recipeapp.R
import com.yuriikonovalov.recipeapp.databinding.DialogSourcePageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SourcePageDialog : DialogFragment() {
    private lateinit var binding: DialogSourcePageBinding
    private val args: SourcePageDialogArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = DialogSourcePageBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun getTheme(): Int {
        return R.style.Theme_RecipeApp_FullScreenDialog
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.bindWebView()
        binding.bindToolbar()
    }

    private fun DialogSourcePageBinding.bindWebView() {
        webView.webViewClient = object : WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                binding.progressBar.isGone = true
            }
        }
        webView.loadUrl(args.url)
    }

    private fun DialogSourcePageBinding.bindToolbar() {
        toolbar.title = args.url
        toolbar.setNavigationOnClickListener { dialog?.dismiss() }
        toolbar.setOnMenuItemClickListener { menuItem ->
            when (menuItem.itemId) {
                R.id.menu_web_view_copy_url -> {
                    copyUrl()
                    true
                }
                R.id.menu_web_view_open_in_browser -> {
                    openInBrowser()
                    true
                }
                else -> false
            }
        }
    }

    private fun openInBrowser() {
        val intent = Intent(Intent.ACTION_VIEW).apply {
            data = Uri.parse(args.url)
        }
        try {
            startActivity(intent)
        } catch (e: ActivityNotFoundException) {
            Toast.makeText(
                requireContext(),
                getString(R.string.cannot_open_browser),
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    private fun copyUrl() {
        val clipboard =
            requireContext().getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText("Url", args.url)
        clipboard.setPrimaryClip(clip)

        // Feedback as a toast for Android 12 and lower.
        // Starting from Android 13 there's a standard visual confirmation.
        if (Build.VERSION.SDK_INT <= Build.VERSION_CODES.S_V2) {
            Toast.makeText(requireContext(), getString(R.string.copied), Toast.LENGTH_SHORT).show()
        }
    }
}
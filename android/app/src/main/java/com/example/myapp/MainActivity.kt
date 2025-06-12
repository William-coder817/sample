package com.example.myapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    companion object {
        init {
            System.loadLibrary("native-lib") // Load native library
        }
    }

    // Native method declaration
    private external fun getNativeVersion(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        displayNativeVersion()
    }

    private fun displayNativeVersion() {
        try {
            val version = getNativeVersion()
            updateVersionText("Native Version: $version")
        } catch (e: UnsatisfiedLinkError) {
            updateVersionText("Error: Native library not loaded")
            e.printStackTrace()
        } catch (e: Exception) {
            updateVersionText("Error: ${e.localizedMessage}")
            e.printStackTrace()
        }
    }

    private fun updateVersionText(text: String) {
        runOnUiThread {
            binding.versionText.text = text
        }
    }
}
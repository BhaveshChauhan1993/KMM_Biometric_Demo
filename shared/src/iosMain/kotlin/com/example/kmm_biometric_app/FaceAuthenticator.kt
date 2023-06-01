package com.example.kmm_biometric_app

import kotlinx.cinterop.ObjCObjectVar
import kotlinx.cinterop.alloc
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.Foundation.NSError
import platform.LocalAuthentication.LAContext
import platform.LocalAuthentication.LAPolicyDeviceOwnerAuthentication

actual class FaceAuthenticator {

    actual fun isDeviceHasBiometric(): Boolean {
        // Check if face authentication is available
        val context = LAContext()

        memScoped {
            val error = alloc<ObjCObjectVar<NSError?>>()
            return context.canEvaluatePolicy(LAPolicyDeviceOwnerAuthentication, error.ptr)
        }
    }

    actual fun authenticateWithFace(callback: (Boolean) -> Unit) {
        // Authenticate using biometric
        val context = LAContext()
        val reason = "Authenticate using face"

        if (isDeviceHasBiometric()) {
            // Perform face authentication
            context.evaluatePolicy(
                LAPolicyDeviceOwnerAuthentication,
                localizedReason = reason
            ) { b: Boolean, nsError: NSError? ->
                callback(b)
                if (!b) {
                    print(nsError?.localizedDescription ?: "Failed to authenticate")
                }
            }
        }

        callback(false)
    }

}

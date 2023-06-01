package com.example.kmm_biometric_app


expect class FaceAuthenticator {
    fun isDeviceHasBiometric(): Boolean
    fun authenticateWithFace(callback: (Boolean) -> Unit)
}

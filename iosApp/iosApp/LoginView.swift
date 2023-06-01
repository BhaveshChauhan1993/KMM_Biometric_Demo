//
//  LoginView.swift
//  iosApp
//
//  Created by Bhavesh Chauhan on 01/06/23.
//  Copyright © 2023 orgName. All rights reserved.
//

import SwiftUI
import shared

struct LoginView: View {
    var body: some View {
        var isFaceAuthenticated :Bool = false
        let faceAuthenticator = FaceAuthenticator()
        
        Button(action: {
            if(faceAuthenticator.isDeviceHasBiometric()){
                faceAuthenticator.authenticateWithFace { isSuccess in
                    isFaceAuthenticated = isSuccess.boolValue
                    if (isFaceAuthenticated){
                        print("LoginView", "Authentication Successful")
                    }else{
                        print("LoginView", "Authentication Failed")
                    }
                }
            }
        }) {
            Text("Authenticate")
            .padding()
            .background(Color.blue)
            .foregroundColor(.white)
            .cornerRadius(10)
        }
        
    }
}

struct LoginView_Previews: PreviewProvider {
    static var previews: some View {
        LoginView()
    }
}


package com.example.sebsz.hubmobile.network.messages;

public class HandshakeRequest {
    public byte[] Name;

    public HandshakeRequest() {
        Name = new byte[Definition.HandshakeNameSize * Definition.FourBytes];
    }
}

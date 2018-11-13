package com.example.sebsz.hubmobile.network.messages;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class NetworkMessage {
    public byte ID;
    public byte[] REQUEST;

    public NetworkMessage() {
        REQUEST = new byte[Definition.NetworkMessageSize - 1];
    }

    public byte[] serialize() {
        byte[] bytes = new byte[this.REQUEST.length + 1];
        bytes[0] = this.ID;
        System.arraycopy(this.REQUEST, 0, bytes, 1, this.REQUEST.length);

        return  bytes;
    }
}

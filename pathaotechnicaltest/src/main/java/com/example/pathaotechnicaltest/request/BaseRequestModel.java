package com.example.pathaotechnicaltest.request;

import com.sun.media.sound.InvalidDataException;

public abstract class BaseRequestModel {
    public abstract void validate() throws InvalidDataException;
}

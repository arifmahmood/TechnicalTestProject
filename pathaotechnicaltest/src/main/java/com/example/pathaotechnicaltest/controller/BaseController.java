package com.example.pathaotechnicaltest.controller;

import com.example.pathaotechnicaltest.request.BaseRequestModel;
import com.sun.media.sound.InvalidDataException;

public abstract class BaseController {
    void validate(BaseRequestModel baseRequestModel) throws InvalidDataException {
        baseRequestModel.validate();
    }
}

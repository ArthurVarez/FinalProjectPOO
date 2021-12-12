package com.FinalProject.Pattern.Factory;

import com.FinalProject.Pattern.IPattern;

/**
 * Generic Factory interface used for factories
 * Allow classes that implements this interface to create object given a specific data
 */
public interface  AFactory<T> extends IPattern {
    T CreateObject (String data);
}

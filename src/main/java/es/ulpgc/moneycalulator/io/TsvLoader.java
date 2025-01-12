package es.ulpgc.moneycalulator.io;

import java.io.File;

public interface TsvLoader {
    TsvLoader loadFrom(File file);
}

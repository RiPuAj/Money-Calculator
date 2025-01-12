package es.ulpgc.moneycalulator.io;

import java.io.File;
import java.io.IOException;

public interface TsvLoader {
    TsvLoader loadFrom(File file);
}

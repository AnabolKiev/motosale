package com.anabol.motosale.dao;

import org.springframework.stereotype.Repository;
import java.util.*;

public interface ParserDao {
    public HashMap<String, String> parseLinks(String urlToRead, String selector);
}

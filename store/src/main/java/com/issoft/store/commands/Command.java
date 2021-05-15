package com.issoft.store.commands;

import com.issoft.store.Product;

import java.io.IOException;
import java.util.List;

public interface Command {

    void execute(List<Product> products) throws IOException;
}

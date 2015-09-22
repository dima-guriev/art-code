package com.artcode.task1;

import com.artcode.task1.logic.CompanyCreator;
import com.artcode.task1.logic.Menu;

/**
 * Created by dimasik on 21.09.15.
 */
public class Runner {
    public static void main(String[] args) {
        Menu.showMenu(CompanyCreator.defaultCompany());
    }
}

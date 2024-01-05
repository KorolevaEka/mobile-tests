package tests;

import utils.Utils;

import java.util.Date;

public class TestData {
    Utils utils = new Utils();
    Date date = new Date();
    public String currentDate = utils.getDate("MMM d, yyyy", date);
}
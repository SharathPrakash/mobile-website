package com.src.services;

public interface Verification {
	boolean numberCheck(String input);
	boolean keywordCheck(String input);
	boolean emailCheck(String input);
	boolean passwordCount(String input);
	boolean charecterCheck(String input);
	boolean managerCheck(String input);
}

package com.company.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StackUtilTest {

    @Test
    void test_stackArrayImplementation() {
        StackUtil.stackArrayImplementation();
    }

    @Test
    void test_stackLinkedImplementation() {
        StackUtil.stackLinkedImplementation();
    }

    @Test
    void test_isPalindrome() {
        Assertions.assertTrue(StackUtil.isPalindrome("rAcEcar"));
    }

    @Test
    void test_isPalindrome_punctuationAndWhitespace() {
        Assertions.assertTrue(StackUtil.isPalindrome("r,Ac Ecar!"));
    }

    @Test
    void test_isPalindrome_sentence() {
        Assertions.assertTrue(StackUtil.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    void test_isPalindrome_anotherSentence() {
        Assertions.assertTrue(StackUtil.isPalindrome("Don't nod!"));
    }

    @Test
    void test_isPalindrome_blankString() {
        Assertions.assertFalse(StackUtil.isPalindrome(""));
    }

    @Test
    void test_isPalindrome_nullString() {
        Assertions.assertFalse(StackUtil.isPalindrome(null));
    }

    @Test
    void test_isPalindrome_whitespace() {
        Assertions.assertFalse(StackUtil.isPalindrome(" "));
    }

    @Test
    void test_isPalindrome_punctuation() {
        Assertions.assertFalse(StackUtil.isPalindrome("!?,."));
    }

}
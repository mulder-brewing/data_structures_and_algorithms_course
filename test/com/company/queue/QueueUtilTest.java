package com.company.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class QueueUtilTest {

    @Test
    void test_arrayQueue() {
        QueueUtil.arrayQueue();
    }

    @Test
    void test_circularQueue() {
        QueueUtil.circularQueue();
    }

    @Test
    void test_isPalindrome() {
        Assertions.assertTrue(QueueUtil.isPalindrome("rAcEcar"));
    }

    @Test
    void test_isPalindrome_punctuationAndWhitespace() {
        Assertions.assertTrue(QueueUtil.isPalindrome("r,Ac Ecar!"));
    }

    @Test
    void test_isPalindrome_sentence() {
        Assertions.assertTrue(QueueUtil.isPalindrome("Was it a car or a cat I saw?"));
    }

    @Test
    void test_isPalindrome_anotherSentence() {
        Assertions.assertTrue(QueueUtil.isPalindrome("Don't nod!"));
    }

    @Test
    void test_isPalindrome_blankString() {
        Assertions.assertFalse(QueueUtil.isPalindrome(""));
    }

    @Test
    void test_isPalindrome_nullString() {
        Assertions.assertFalse(QueueUtil.isPalindrome(null));
    }

    @Test
    void test_isPalindrome_whitespace() {
        Assertions.assertFalse(QueueUtil.isPalindrome(" "));
    }

    @Test
    void test_isPalindrome_punctuation() {
        Assertions.assertFalse(QueueUtil.isPalindrome("!?,."));
    }

}
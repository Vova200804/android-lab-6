package com.example.unscramble.ui.test

import com.example.unscramble.ui.GameViewModel
import org.junit.Test
import org.junit.Assert.*

class GameViewModelEdgeTest {
    @Test fun repeated_word_is_rejected_and_reset_clears_input() {
        val words = listOf("animal", "animal", "android", "banana").iterator()
        val vm = GameViewModel { words.next() }
        vm.skipWord()
        assertEquals(2, vm.uiState.value.currentWordCount)
        assertEquals("android".toList().sorted(), vm.uiState.value.currentScrambledWord.toList().sorted())
        vm.updateUserGuess("unfinished")
        vm.resetGame()
        assertEquals("", vm.userGuess)
        assertEquals(0, vm.uiState.value.score)
        assertEquals(1, vm.uiState.value.currentWordCount)
        assertFalse(vm.uiState.value.isGameOver)
    }
}

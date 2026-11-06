package com.example.artspace6

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import org.junit.Rule
import org.junit.Test

class ArtUiTest {
    @get:Rule val rule = createAndroidComposeRule<MainActivity>()
    @Test fun next_previous_and_recreation() {
        rule.onNodeWithTag("next").performClick()
        rule.onNodeWithText("2 из 3").assertExists()
        rule.activityRule.scenario.recreate()
        rule.onNodeWithText("2 из 3").assertExists()
        rule.onNodeWithTag("previous").performClick()
        rule.onNodeWithText("1 из 3").assertExists()
        rule.onNodeWithTag("previous").performClick()
        rule.onNodeWithText("3 из 3").assertExists()
    }
}

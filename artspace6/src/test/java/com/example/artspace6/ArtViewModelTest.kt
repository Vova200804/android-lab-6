package com.example.artspace6
import org.junit.Test
import org.junit.Assert.*
class ArtViewModelTest {@Test fun next_and_previous_wrap(){val vm=ArtViewModel();vm.previous();assertEquals(2,vm.uiState.value.index);vm.next();assertEquals(0,vm.uiState.value.index);repeat(3){vm.next()};assertEquals(0,vm.uiState.value.index)}}

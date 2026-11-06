package com.example.activitylifecycle
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.platform.testTag

import android.util.Log
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale
object LifecycleHistory{val events=mutableStateListOf<String>()}
class MainActivity:ComponentActivity(){
 private fun record(name:String){Log.d("ActivityLifecycle",name);LifecycleHistory.events.add("${SimpleDateFormat("HH:mm:ss.SSS",Locale.ROOT).format(Date())}  $name")}
 override fun onCreate(savedInstanceState:Bundle?){super.onCreate(savedInstanceState);record("onCreate");enableEdgeToEdge();setContent{MaterialTheme{Surface(Modifier.fillMaxSize()){Column(Modifier.safeDrawingPadding().padding(24.dp).verticalScroll(rememberScrollState()),verticalArrangement=Arrangement.spacedBy(12.dp)){Text("Жизненный цикл Activity",style=MaterialTheme.typography.headlineMedium);Text("Сверните приложение, вернитесь и поверните экран. Ниже показаны реальные вызовы методов.");HorizontalDivider();LifecycleHistory.events.forEach{Text(it,style=MaterialTheme.typography.bodyLarge)}}}}}}
 override fun onStart(){super.onStart();record("onStart")}
 override fun onResume(){super.onResume();record("onResume")}
 override fun onPause(){record("onPause");super.onPause()}
 override fun onStop(){record("onStop");super.onStop()}
 override fun onRestart(){super.onRestart();record("onRestart")}
 override fun onDestroy(){record("onDestroy");super.onDestroy()}
}

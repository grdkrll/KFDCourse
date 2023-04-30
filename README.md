# Зачет по KFD Course

## Codelabs Fundamentals

### 1.1

Я научился простейшей работе с Android Studio и познакомился со структурой проекта Android приложения

Ответы на вопросы в ДЗ:

1. activity_main.xml
2. applicationId
3. Device Manager
4. Verbose, Info

### 1.2

Я научился работе с layout в Android в Android Studio

Ответы на вопросы в ДЗ:

1. app:layout_constraintBottom_toTopOf="@+id/button_count", app:layout_constraintTop_toBottomOf="@+id/button_toast"
2. app:layout_constraintLeft_toLeftOf="parent"
3. public void callMethod(View view)
4. view.setBackgroundColor()

### 1.3

Я научился работать с ScrollView и LinearLayout

Ответы на вопросы в ДЗ:

1. One view or one view group
2. android:orientation="horizontal"
3. android:layout_width="wrap_content"

### 1.4

Я научился менять иконку приложения и изучил Basic Template в Android Studio. Узнал о официальной документации Android и работе с Android SDK в Android Studio

Ответы на вопросы в ДЗ:

1. File > New > Import Sample
2. Navigation buttons, Floating action button
3. developer.android.com

### 2.1

Я научился работать с Intent

Ответы на вопросы в ДЗ:

1. The second Activity is added as a Java class, the XML layout file is created, and the AndroidManifest.xml file is changed to declare a second Activity
2. The Up button in the app bar no longer appears in the second Activity to send the user back to the parent Activity
3. new Intent(Context context, Class<?> class)
4. As an Intent extra
5. Get the current count value out of the Intent

### 2.2

Я узнал о методах цикла жизни приложения в Android и как сохранить состояние приложения

Ответы на вопросы в ДЗ:

1. The counter is reset to 0, and the EditText no longer contains the text you entered
2. Android shuts down your Activity by calling onPause(), onStop(), and onDestroy(), and then starts it over again, calling onCreate(), onStart(), and onResume()
3. onSaveInstanceState() is called before the onStop() method
4. onPause() or onStop()

### 2.3

Я узнал о Implicit Intent и как с ними работать

Ответы на вопросы в ДЗ:

1. new Intent(String action)
2. All of the above
3. Intent takePicture = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

### 3.1

Я узнал как пользоваться дебаггером в Android Studio

Ответы на вопросы в ДЗ:

1. java.lang.NumberFormatException: empty String
2. Step Over
3. Step Into

### 3.2

Я узнал о том, как надо тестировать Android приложение (Unit тесты, Mockito)

Ответы на вопросы в ДЗ:

1. Tests that are compiled and run entirely on your local machine with the Java Virtual Machine (JVM)
2. com.example.android.SimpleCalcTest (test)
3. @Test

### 3.3

Я узнал о версиях SDK и о том как управлять версиями зависимостей (dependencies)

Ответы на вопросы в ДЗ:

1. ContextCompat
2. return context.getColor(id);
3. If your minSdkVersion is 15, the word getColor is underlined in red in the code editor. Hover your pointer over it, and Android Studio reports "Call requires API 23 (current min is 15)"

### 5.2

Я узнал о том как использовать CardView, ImageView, FAB, познакомился с Material Design

Ответы на вопросы в ДЗ:

1. colorPrimaryDark
2. v7 Support Library
3. Any color shade labeled 500

### 5.3

Я узнал о GridLayoutManager и о том, как поддерживать несколько языков в Android приложении

1. Smallest screen width
2. res/values-fr-rCA/
3. res/values

### 8.1

Я узнал как управлять уведомлениями

Ответы на вопросы в ДЗ:

1. You use notification channels to display notifications to the user in the device status bar, You use notification channels to group multiple notifications so that the user can control the notifications' behavior
2. NotificationManager.notify()
3. PendingIntent that's sent when the user taps the action button
4. NotificationCompat.Builder.addAction()
5. PendingIntent.getBroadcast()

### 10.1

Я познакомился с Room, LiveData, ViewModel, DAO

Ответы на вопросы в ДЗ:

1. Eliminates a lot of boilerplate code
2. Cleanly separates the UI from the backend, Often used with LiveData for changeable data that the UI will use or display, Acts as a communication center between the Repository and the UI
3. Short for "data access object."
4. When LiveData is used with Room, data updates automatically if all the intermediate levels also return LiveData (DAO, ViewModel, Repository), Uses the observer pattern and notifies its observers when its data has changed, Is lifecycle aware

## Jetpack Compose basics

Я познакомился с Jetpack Compose и узнал о работе в нем (State, LazyList, Animation, Themes)

## Advanced State and Side Effects in Jetpack Compose

Я познакомился с функциями работы с состоянием приложения в Jetpack Compose

package com.example.notifyme

import android.app.Notification
import android.app.Notification.InboxStyle
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.graphics.BitmapFactory
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.NotificationCompat


class MainActivity : AppCompatActivity() {

    companion object {
        private const val PRIMARY_CHANNEL_ID = "primary_notification_channel"
        private const val NOTIFICATION_ID = 0
        private val ACTION_UPDATE_NOTIFICATION =
            "com.example.android.notifyme.ACTION_UPDATE_NOTIFICATION"
    }

    private var buttonNotify: Button? = null
    private var buttonUpdate: Button? = null
    private var buttonCancel: Button? = null
    private var mNotifyManager: NotificationManager? = null
    private val mReceiver = NotificationReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonNotify = findViewById(R.id.notify)
        buttonNotify?.setOnClickListener(View.OnClickListener {
            @Override
            fun onClick(view: View) {
                sendNotification()
            }
        })
        buttonUpdate = findViewById(R.id.update)
        buttonUpdate?.setOnClickListener(View.OnClickListener {
            @Override
            fun onClick(view: View) {
                updateNotification()
            }
            //Update the notification
        })

        buttonCancel = findViewById(R.id.cancel)
        buttonCancel?.setOnClickListener(View.OnClickListener {
            @Override
            fun onClick(view: View) {
                cancelNotification()
            }
            //Cancel the notification
        })
        createNotificationChannel()
        setNotificationButtonState(true, false, false)
        registerReceiver(mReceiver, IntentFilter(ACTION_UPDATE_NOTIFICATION))

    }

    fun updateNotification() {
        val androidImage = BitmapFactory
            .decodeResource(resources, R.drawable.mascot_1)
        val notifyBuilder = getNotificationBuilder()
        notifyBuilder.setStyle(
            NotificationCompat.BigPictureStyle()
                .bigPicture(androidImage)
                .setBigContentTitle("Notification Updated!")
        )
        mNotifyManager?.notify(NOTIFICATION_ID, notifyBuilder.build())
        setNotificationButtonState(false, false, true);
    }

    fun setNotificationButtonState(
        isNotifyEnabled: Boolean,
        isUpdateEnabled: Boolean,
        isCancelEnabled: Boolean
    ) {
        buttonNotify?.isEnabled = isNotifyEnabled
        buttonUpdate?.isEnabled = isUpdateEnabled
        buttonCancel?.isEnabled = isCancelEnabled
    }

    fun cancelNotification() {
        mNotifyManager?.cancel(NOTIFICATION_ID)
        setNotificationButtonState(true, false, false)
    }

    fun createNotificationChannel() {
        getSystemService(NOTIFICATION_SERVICE);
        if (android.os.Build.VERSION.SDK_INT >=
            android.os.Build.VERSION_CODES.O
        ) {
            val notificationChannel = NotificationChannel(
                PRIMARY_CHANNEL_ID,
                "Mascot Notification", NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.enableLights(true)
            notificationChannel.lightColor = Color.RED
            notificationChannel.enableVibration(true)
            notificationChannel.description = "Notification from Mascot"
            mNotifyManager?.createNotificationChannel(notificationChannel)
        }
    }

    fun sendNotification() {
        val updateIntent = Intent(ACTION_UPDATE_NOTIFICATION)
        val updatePendingIntent = PendingIntent.getBroadcast(
            this,
            NOTIFICATION_ID,
            updateIntent,
            PendingIntent.FLAG_ONE_SHOT or PendingIntent.FLAG_IMMUTABLE
        )
        val notifyBuilder = getNotificationBuilder()
        notifyBuilder.addAction(R.drawable.ic_update, "Update Notification", updatePendingIntent);
        mNotifyManager!!.notify(NOTIFICATION_ID, notifyBuilder.build())
        setNotificationButtonState(false, true, true)

    }

    fun getNotificationBuilder(): NotificationCompat.Builder {
        val notificationIntent = Intent(this, MainActivity::class.java)
        val notificationPendingIntent = PendingIntent.getActivity(
            this,
            NOTIFICATION_ID, notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT
        )
        return NotificationCompat.Builder(this, PRIMARY_CHANNEL_ID)
            .setContentTitle("You've been notified!")
            .setContentText("This is your notification text.")
            .setSmallIcon(R.drawable.ic_android).setContentIntent(notificationPendingIntent)
            .setAutoCancel(true).setPriority(NotificationCompat.PRIORITY_HIGH)
            .setDeleteIntent(createOnDismissedIntent(this, NOTIFICATION_ID))
            .setDefaults(NotificationCompat.DEFAULT_ALL)

    }

    private fun createOnDismissedIntent(
        context: Context,
        notificationId: Int
    ): PendingIntent? {
        val intent = Intent(context, NotificationReceiver::class.java)
        intent.putExtra("com.example.notifyme.notificationId", notificationId)
        return PendingIntent.getBroadcast(
            context.applicationContext,
            notificationId, intent, PendingIntent.FLAG_IMMUTABLE
        )
    }

    override fun onDestroy() {
        unregisterReceiver(mReceiver);
        super.onDestroy()
    }

    inner class NotificationReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            val notificationId = intent.extras?.getInt("com.my.app.notificationId")
            updateNotification()
        }

    }
}
## Static Broadcast Receiver
### Let's add receivers to the manifest file:
```xml
<receiver android:name=".MainActivity$InsideBroadcast"></receiver>
<receiver android:name=".OutsideBroadcast"></receiver>
```
### 1. Creating a Broadcast Receiver class within its own class:
```kotlin
class InsideBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Get data and show.
        var bundle : Bundle = intent!!.extras!!
        var message : String? = bundle.getString("message")
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
}
```
### Running a Broadcast Receiver class within its own class:
```kotlin
fun insideBroadcast(view : View){
    // Submit data to InsideBroadcast.
    val intent : Intent = Intent(this,InsideBroadcast::class.java)
    val bundle : Bundle = Bundle()
    bundle.putString("message","Static Broadcast Receiver is running inside the Class...")
    intent.putExtras(bundle)
    sendBroadcast(intent)
}
```
### 2. Creating a Broadcast Receiver class other than its own class:
```kotlin
class OutsideBroadcast : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        // Gonderilen veriyi al ve goster.
        var bundle : Bundle = intent!!.extras!!
        var message : String? = bundle.getString("message")
        Toast.makeText(context,message,Toast.LENGTH_LONG).show()
    }
}
```
### Calling a Broadcast Receiver class:
```kotlin
fun outsideBroadcast(view : View){
    // Submit data to OutsideBroadcast.
    val intent : Intent = Intent(this,OutsideBroadcast::class.java)
    val bundle : Bundle = Bundle()
    bundle.putString("message","Static Broadcast Receiver is running outside the Class...")
    intent.putExtras(bundle)
    sendBroadcast(intent)
}
```

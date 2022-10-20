# Smart Dialog

An Android library that solves all Dialog Needs

## Importing

The library may be found on Maven Central repository.
Add it to your project by adding the following dependency:

```groovy
implementation 'com.github.GtechGovind:SmartDialog:1.0'
```

Also uh need to add following in settings.gradle

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url 'https://jitpack.io' }
    }
}
```

## Usage

This lib offers two types of dialogs Loading Dialog & Aleart Dailog

### Loading Dialog

This functions can only be called in Activity or Fragment

```groovy
startLoader("Pass your message")
              or
startLoader() // default message : Please wait loading 
```

### Aleart Dialog

This functions can only be called in Activity or Fragment

#### Function Defination

```groovy

enum class DialogType {
    SUCCESS,
    INFO,
    ERROR
}

showAlert(message: String, type: DialogType, dialogListeners: DialogListeners? = null)

```

You can extend your Activity & Fragment with "DialogListeners" in order to recive button click event

#### Example (With DialogListeners)

If you use "DialogListeners" then dont forget to call dialog?.dismiss()

```groovy

class ChatFragment : Fragment(), DialogListeners {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAlert("hello", DialogType.SUCCESS, this)
    }

    override fun onDialogClick(dialog: Dialog?, type: DialogType) {
        // Do user stuff
        dialog?.dismiss()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    
}

```

#### Example (Without DialogListeners)

class ChatFragment : Fragment() {

    private var _binding: FragmentChatBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentChatBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        showAlert("hello", DialogType.SUCCESS)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
    
}

```


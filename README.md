
# StateWrapperCompose

StateWrapperCompose is a simple example demonstrating how to handle different states in a Kotlin-based Android application using a sealed interface and a state management approach. It simulates a repository interaction where data is loaded, and various states such as loading, success, and failure are managed and displayed in the UI.

## Features

- **Loading State**: Show a loading spinner while data is being fetched.
- **Success State**: Display the fetched data on a success screen.
- **Error State**: Display an error message when an exception occurs.
- **Sealed Interface**: Use Kotlin's sealed interface to manage different states in a clean and scalable way.

## Technologies Used

- **Kotlin**: The language used for this project.
- **Jetpack Compose**: For building the UI declaratively.
- **Koin**: For dependency injection and managing the repository and ViewModel.
- **Flow**: For handling asynchronous data streams.
- **StateFlow**: To manage UI state reactively.

## Setup

1. Clone the repository:

   ```bash
   git clone https://github.com/wookoowooko/StateWrapperCompose.git
   cd StateWrapperCompose
   ```

2. Open the project in Android Studio.

3. Run the app on an emulator or a physical device.

## Code Walkthrough

### 1. `StateWrapper` Interface
We define a sealed interface to represent different states of data:
- **Loading**: When the data is being fetched.
- **Success**: When the data is successfully fetched.
- **Failure**: When there is an error while fetching the data.

### 2. Repository Implementation
The `RepositoryImpl` class simulates loading data and throws an exception to simulate a failure. The states are emitted using Kotlin's `Flow` to be observed by the UI.

### 3. ViewModel
The `AppViewModel` observes the `StateWrapper` states and updates the UI accordingly. It reacts to state changes like loading, success, and failure.

### 4. UI
The UI uses Jetpack Compose to display different screens based on the current state. It includes:
- `LoadingScreen`: Displays a loading spinner.
- `ErrorScreen`: Displays an error message.
- `SuccessScreen`: Displays the success message.
- `ContentScreen`: Displays the content (data).

### 5. Koin Setup
We use Koin for dependency injection to provide the `AppViewModel` and `RepositoryImpl` dependencies.

## Example

When the app is started, the following sequence happens:

1. **Loading State**: A loading screen is shown.
2. **Success State**: After a simulated delay, the data is fetched, and a success screen is displayed.
3. **Error State**: If an error occurs (simulated by throwing an exception), the error screen is shown.

## Contributing

Feel free to fork the repository, open issues, and submit pull requests.

## License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Thank You!

Thank you for reading!


## Medium
[Building a State Management Wrapper for Android Using Koin, and Jetpack Compose in 2024](https://wookoo.medium.com/building-a-state-management-wrapper-for-android-using-koin-and-jetpack-compose-4cad098ca892).


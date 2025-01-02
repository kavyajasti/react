import React from 'react';
import { Platform, TouchableOpacity, Button as NativeButton, Text as NativeText, View, AppRegistry } from 'react-native';
import ReactDOM from 'react-dom';

// Button Component
const Button = ({ title, onPress }) => {
  if (Platform.OS === 'web') {
    return <button onClick={onPress}>{title}</button>;
  }
  return (
    <TouchableOpacity onPress={onPress}>
      <NativeButton title={title} onPress={onPress} />
    </TouchableOpacity>
  );
};

// Text Component
const Text = ({ children }) => {
  if (Platform.OS === 'web') {
    return <p>{children}</p>;
  }
  return <NativeText>{children}</NativeText>;
};

// Main App Component
function App() {
  if (Platform.OS === 'web') {
    return (
      <div>
        <Text>Welcome to the Web UI Library</Text>
        <Button title="Click Me" onPress={() => alert('Web Button Clicked')} />
      </div>
    );
  }
  return (
    <View style={{ padding: 20 }}>
      <Text>Welcome to the Native UI Library</Text>
      <Button title="Click Me" onPress={() => alert('Native Button Clicked')} />
    </View>
  );
}

// Render for Web
if (Platform.OS === 'web') {
  ReactDOM.render(<App />, document.getElementById('root'));
}

// Render for Native
if (Platform.OS !== 'web') {
  AppRegistry.registerComponent('MyUILibrary', () => App);
}

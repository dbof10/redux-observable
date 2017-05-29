#!/bin/bash

# Fix the CircleCI path
function install() {
  TARGET="$1"
  if [ ! -e $TARGET ]; then
    echo y | android update sdk --no-ui --all --filter $2
  else
    echo "$TARGET has installed"
  fi
}

function installNode(){
  TARGET="$1"
  if [ ! -e $TARGET ]; then
     cd react && npm install && cd ..
  else
     echo "$TARGET has installed"
  fi
}

function getNode(){
  installNode react/node_modules
}

function getAndroidSDK() {
  export PATH="$ANDROID_HOME/platform-tools:$ANDROID_HOME/tools:$PATH"

  install $ANDROID_HOME/platforms/android-25 android-25 &&
  install $ANDROID_HOME/build-tools/25.0.2 build-tools-25.0.2 &&
  install $ANDROID_HOME/extras/android/m2repository/com/android/support/appcompat-v7/25.2.0 extra-android-m2repository &&
  install $ANDROID_HOME/extras/android/m2repository/com/android/support/support-v4/25.2.0 extra-android-support &&
  install $ANDROID_HOME/extras/google/m2repository/com/google/android/gms/play-services/9.8.0 extra-google-m2repository
}

#!/bin/bash

osascript -e "tell application \"Finder\" to set desktop picture to POSIX file \"$1\""

#osascript -e "tell application \"Finder\" to set desktop picture to POSIX file \"$localpath$time\""
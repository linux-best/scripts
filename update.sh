#!/bin/bash

var=/etc/os-release

if grep -q "Arch" $var
then
    # it will update for arch system
    sudo pacman -Syu
fi

if grep -q "Ubuntu" $var || grep -q "Pop" $var
then
    # update on ubuntu and pop-os
    sudo apt update &>/dev/null
    #sudo apt upgrade
fi

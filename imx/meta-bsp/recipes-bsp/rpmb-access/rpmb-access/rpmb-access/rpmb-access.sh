#!/bin/bash

############# Provide rpmb block access ########################
echo -n AAAABBBBCCCCDDDDEEEEFFFFGGGGHHHH | mmc rpmb write-key /dev/mmcblk0rpmb -

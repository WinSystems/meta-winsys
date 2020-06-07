# Copyright 2017-2018 NXP
# Released under the MIT license (see COPYING.MIT for the terms)

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

SRCBRANCH = "4.14.78"
LOCALVERSION = "-${SRCBRANCH}"
KERNEL_SRC ?= "git://github.com/WinSystems/linux-imx8m.git;protocol=https"
SRC_URI = "${KERNEL_SRC};branch=${SRCBRANCH}"
SRCREV = "9babf2cddd48c7aa3570c3769d5b0d36b7a901a0"

S = "${WORKDIR}/git"

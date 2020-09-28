HOMEPAGE = "http://www.denx.de/wiki/U-Boot/WebHome"
SECTION = "bootloaders"
DEPENDS += "flex-native bison-native"

LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://Licenses/README;md5=30503fd321432fc713238f582193b78e"
PE = "1"


# We use the revision in order to avoid having to fetch it from the
# repo during parse

UBOOT_SRC ?= "git://github.com/WinSystems/u-boot-imx8m.git;protocol=https"
SRCBRANCH = "v2020.04"
SRC_URI = "${UBOOT_SRC};branch=${SRCBRANCH} \
"
SRCREV = "${AUTOREV}"






S = "${WORKDIR}/git"

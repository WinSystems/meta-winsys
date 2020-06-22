SUMMARY = "Adds the user winsys"
DESCRIPTION = "Recipe for adding the default user winsys to the image"
LICENSE = "Proprietary"
LIC_FILES_CHKSUM = "file://${TOPDIR}/../sources/meta-winsys/imx/COPYING;md5=ab61cab9599935bfe9f700405ef00f28"

SRC_URI = "file://rs485-support"

S = "${WORKDIR}/rs485-support"

inherit useradd

DEPENDS += " weston"


# You must set USERADD_PACKAGES when you inherit useradd. This
# lists which output packages will include the user/group
# creation code.
USERADD_PACKAGES = "${PN}"

# You must also set USERADD_PARAM and/or GROUPADD_PARAM when
# you inherit useradd.

# USERADD_PARAM specifies command line options to pass to the
# useradd command. 
USERADD_PARAM_${PN} = "-u 1200 -d /home/winsys -r -s /bin/bash -p 'winsys' -G weston-launch,video winsys;"
#USERADD_PARAM = "-u 1200 -d /home/winsys -r -s /bin/bash -p 'winsys' -G weston-launch,video,disk,tty winsys;"

RDEPENDS_${PN} += " bash "

do_install () {
        install -d -m 755 ${D}${datadir}/winsys
        install -d -m 755 ${D}/home/winsys
	install -d -m 755 ${D}/home/winsys/serial-scripts/
	cp -r ${S}/* ${D}/home/winsys/serial-scripts/

        chown -R winsys:winsys ${D}${datadir}/winsys
        chown -R winsys:winsys ${D}/home/winsys

}

FILES_${PN} = "${datadir}/winsys /home/winsys"


# Prevents do_package failures with:
# debugsources.list: No such file or directory:
#INHIBIT_PACKAGE_DEBUG_SPLIT = "1"









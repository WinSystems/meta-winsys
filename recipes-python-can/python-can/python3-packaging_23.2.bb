
SUMMARY = "Core utilities for Python packages"
HOMEPAGE = ""
AUTHOR = " <Donald Stufft <donald@stufft.io>>"
LICENSE = "GPL"
LIC_FILES_CHKSUM = "file://LICENSE.APACHE;md5=2ee41112a44fe7014dce33e26468ba93"

SRC_URI = "https://files.pythonhosted.org/packages/fb/2b/9b9c33ffed44ee921d0967086d653047286054117d584f1b1a7c22ceaf7b/packaging-23.2.tar.gz"
SRC_URI[md5sum] = "d54eeff8c7ca86980528f4132f258d54"
SRC_URI[sha256sum] = "048fb0e9405036518eaaf48a55953c750c11e1a1b68e0dd1a9d62ed0c092cfc5"

S = "${WORKDIR}/packaging-23.2"

RDEPENDS_${PN} = ""

inherit pypi setuptools3

do_configure:prepend() {
    # Add the required line to setup.py
    echo "from setuptools import setup" >> ${S}/setup.py
    echo "setup()" >> ${S}/setup.py
}

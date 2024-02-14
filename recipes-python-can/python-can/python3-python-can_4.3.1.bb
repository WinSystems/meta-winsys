
SUMMARY = "Controller Area Network interface module for Python"
HOMEPAGE = ""
AUTHOR = "python-can contributors <>"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=e6a600fd5e1d9cbde2d983680233ad02"

SRC_URI = "https://files.pythonhosted.org/packages/02/fc/d5fd33ee93f17a4eb0dcd75aebf522396e3f511bf474058e99e86ae4e33f/python-can-4.3.1.tar.gz"
SRC_URI[md5sum] = "a84ace55fdeca8efd50986deacfba584"
SRC_URI[sha256sum] = "008bea1c12e31586e1aa76971126b831bf01056a900e91862a11360e011ab933"

S = "${WORKDIR}/python-can-4.3.1"

RDEPENDS_${PN} = "python3-wrapt python3-packaging python3-typing-extensions libsystemd libsystemd-journal"

inherit pypi setuptools3

do_configure:prepend() {
    # Add the required line to setup.py
    echo "from setuptools import setup" >> ${S}/setup.py
    echo "setup()" >> ${S}/setup.py
}
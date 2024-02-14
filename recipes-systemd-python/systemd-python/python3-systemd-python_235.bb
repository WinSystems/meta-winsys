
SUMMARY = "Python interface for libsystemd"
HOMEPAGE = "https://github.com/systemd/python-systemd"
AUTHOR = " <david@davidstrauss.net>"
LICENSE = "LGPL-2.0"
LIC_FILES_CHKSUM = "file://LICENSE.txt;md5=4fbd65380cdd255951079008b364516c"

SRC_URI = "https://files.pythonhosted.org/packages/10/9e/ab4458e00367223bda2dd7ccf0849a72235ee3e29b36dce732685d9b7ad9/systemd-python-235.tar.gz"
SRC_URI[md5sum] = "93f3ca09f35719ca6a4edd1d62d38dd4"
SRC_URI[sha256sum] = "4e57f39797fd5d9e2d22b8806a252d7c0106c936039d1e71c8c6b8008e695c0a"

S = "${WORKDIR}/systemd-python-235"

RDEPENDS_${PN} = "libsystemd libsystemd-journal"

inherit pypi pkgconfig python3native setuptools3 systemd

PACKAGECONFIG ??= "${@bb.utils.contains('DISTRO_FEATURES', 'systemd', 'with-external-libsystemd', 'with-builtin-libsystemd', d)}"
PACKAGECONFIG[with-builtin-libsystemd] = ",,sdbus-c++-libsystemd,libcap"
PACKAGECONFIG[with-external-libsystemd] = ",,systemd,libsystemd"

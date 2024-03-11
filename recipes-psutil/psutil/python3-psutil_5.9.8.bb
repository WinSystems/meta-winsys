
SUMMARY = "Cross-platform lib for process and system monitoring in Python."
HOMEPAGE = "https://github.com/giampaolo/psutil"
AUTHOR = "Giampaolo Rodola <g.rodola@gmail.com>"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=a9c72113a843d0d732a0ac1c200d81b1"

SRC_URI = "https://files.pythonhosted.org/packages/90/c7/6dc0a455d111f68ee43f27793971cf03fe29b6ef972042549db29eec39a2/psutil-5.9.8.tar.gz"
SRC_URI[md5sum] = "7bb9d4378bd451765b705946a3541393"
SRC_URI[sha256sum] = "6be126e3225486dff286a8fb9a06246a5253f4c7c53b475ea5f5ac934e64194c"

S = "${WORKDIR}/psutil-5.9.8"

RDEPENDS_${PN} = ""

inherit setuptools3

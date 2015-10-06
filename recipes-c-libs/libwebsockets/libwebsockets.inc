DESCRIPTION = "WebSocket Library"
HOMEPAGE = "http://libwebsockets.org"
SECTION = "System/Libraries"
LICENSE = "LGPL-2.1"

SRC_URI = ""

S = "${WORKDIR}/git"

BBCLASSEXTEND = ""
PROVIDES = ""

#PROVIDES by libwebsockets


#PROVIDES by libwebsockets-dev
PROVIDES += "libwebsockets-dev"


RDEPENDS = ""
#RDEPENDS of libwebsockets (${PN})
RDEPENDS_${PN} += "glibc"

#RDEPENDS of libwebsockets-dev (${PN}-dev)
RDEPENDS_${PN}-dev += "libwebsockets"


DEPENDS = ""
#DEPENDS of libwebsockets
DEPENDS += "systemd"
DEPENDS += "zlib"
DEPENDS += "openssl"

inherit pkgconfig cmake

PACKAGES = "${PN}-dbg ${PN}-doc ${PN}-locale"
PACKAGES += " libwebsockets "
PACKAGES += " libwebsockets-dev "
PACKAGES += " libwebsockets-staticdev "

libwebsockets_files = ""
libwebsockets_files += "${prefix}/bin/libwebsockets*"
libwebsockets_files += "${prefix}/lib/libwebsockets*.so.*"
libwebsockets_files += "${prefix}/share/libwebsockets-test-server/*"
MANIFESTFILES_${PN} = "libwebsockets.manifest"

libwebsockets-dev_files = ""
libwebsockets-dev_files += "${prefix}/include/lws_config.h"
libwebsockets-dev_files += "${prefix}/include/libwebsockets.h"
libwebsockets-dev_files += "${prefix}/lib/libwebsockets.so"
libwebsockets-dev_files += "${prefix}/lib/pkgconfig/*"
MANIFESTFILES_${PN}-dev = "libwebsockets.manifest"

libwebsockets-staticdev_files = ""
libwebsockets-statocdev_files += "${prefix}/include/lws_config.h"
libwebsockets-staticdev_files += "${prefix}/include/libwebsockets.h"
libwebsockets-staticdev_files += "${prefix}/lib/libwebsockets.a"
libwebsockets-staticdev_files += "${prefix}/lib/pkgconfig/*"
MANIFESTFILES_${PN}-staticdev = "libwebsockets.manifest"

FILES_${PN} = "${libwebsockets_files}"
FILES_${PN}-dev = "${libwebsockets-dev_files}"

PKG_libwebsockets= "libwebsockets"
PKG_libwebsockets-dev= "libwebsockets-dev"


require libwebsockets.inc

PV = "1.4"

PRIORITY = "10"

LIC_FILES_CHKSUM ??= "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

#SRC_URI += "git://review.tizen.org/profile/ivi/libwebsockets;tag=5c054a5a61ec540e5bd5e2aa55742a3ed070b540;nobranch=1"

SRCREV = "3ae1badae7a05e0982e0dfbcb078da3d4b92a81d"
SRC_URI += "git://github.com/acooks/libwebsockets"


BBCLASSEXTEND += " native "

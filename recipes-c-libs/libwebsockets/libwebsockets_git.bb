require libwebsockets.inc

PV = "1.5"

PRIORITY = "10"

LIC_FILES_CHKSUM ??= "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "9ffb42efec855b36a67a186fab6650e5df7f3f94"
SRC_URI += "git://github.com/warmcat/libwebsockets"

BBCLASSEXTEND += " native "

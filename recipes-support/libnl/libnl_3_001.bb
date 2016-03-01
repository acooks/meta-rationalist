SUMMARY = "A library for applications dealing with netlink sockets"
HOMEPAGE = "http://www.infradead.org/~tgr/libnl/"
SECTION = "libs/network"

LICENSE = "LGPLv2.1"
LIC_FILES_CHKSUM = "file://COPYING;md5=4fbd65380cdd255951079008b364516c"

DEPENDS = "flex-native bison-native"

#SRCREV = "${AUTOREV}"
PR = "r1"
PV = "001-${PR}+git${SRCPV}"

#BRANCH = "master"
#SRC_URI = "git://git.infradead.org/users/tgr/libnl.git;branch=${BRANCH};tag=${TAG}"

BRANCH = "master"
TAG = "libnl3_2_27"
SRC_URI = "git://git.infradead.org/users/tgr/libnl.git;branch=${BRANCH};tag=${TAG}"

#BRANCH = "3_2_25"
#SRC_URI = "git:///mnt/devel/git-repos/libnl.git;branch=${BRANCH}"

S = "${WORKDIR}/git"

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/libnl-3.so.* \
               ${libdir}/libnl.so.* \
               ${sysconfdir}"
RREPLACES_${PN} = "libnl2"
RCONFLICTS_${PN} = "libnl2"
FILES_${PN}-dbg += "${libdir}/libnl/cli/*/.debug"
FILES_${PN}-dev += "${libdir}/libnl/cli/*/*.so \
                    ${libdir}/libnl/cli/*/*.la"
FILES_${PN}-staticdev += "${libdir}/libnl/cli/*/*.a"

PACKAGES += "${PN}-cli ${PN}-route ${PN}-nf ${PN}-xfrm ${PN}-genl ${PN}-idiag"
FILES_${PN}-cli   = "${libdir}/libnl-cli-3.so.* \
                     ${libdir}/libnl/cli/*/*.so.* \
                     ${bindir}/nl-* \
                     ${bindir}/idiag-socket-details \
                     ${bindir}/nf-exp-list \
                     ${bindir}/nf-monitor \
                     ${bindir}/nf-ct-list \
                     ${bindir}/nf-exp-add \
                     ${bindir}/genl-ctrl-list \
                     ${bindir}/nf-exp-delete \
                     ${bindir}/nf-ct-add \
                     ${bindir}/nf-queue \
                     ${bindir}/nf-log"

FILES_${PN}-route = "${libdir}/libnl-route-3.so.*"
FILES_${PN}-idiag = "${libdir}/libnl-idiag-3.so.*"
FILES_${PN}-nf    = "${libdir}/libnl-nf-3.so.*"
FILES_${PN}-xfrm  = "${libdir}/libnl-xfrm-3.so.*"
FILES_${PN}-genl  = "${libdir}/libnl-genl-3.so.* \
                     ${libdir}/libnl-genl.so.* \
                     ${sbindir}/genl-ctrl-list"
RREPLACES_${PN}-genl = "libnl-genl2 libnl-genl-3-200"
RCONFLICTS_${PN}-genl = "libnl-genl2 libnl-genl-3-200"

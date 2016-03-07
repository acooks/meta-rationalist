SUMMARY = "A network delay, jitter and loss test and measurement tool"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=8264535c0c4e9c6c335635c4026a8022"

SRCREV = "${AUTOREV}"
PR = "r3"
PV = "0.08-${PR}+git${SRCPV}"

SRC_URI += "git://github.com/acooks/jittertrap \
           file://jittertrap.service"

S = "${WORKDIR}/git"

inherit pkgconfig systemd

SYSTEMD_SERVICE_${PN} = "jittertrap.service"
SYSTEMD_AUTO_ENABLE_${PN} = "enable"

DEPENDS += "libnl jansson libwebsockets"

# The default yocto git checkout results in a detached HEAD state.
# Detached HEAD sucks, because it breaks the traceability of
# {commit, branch, repo} that helps to support the software.
do_checkout() {
   cd ${S}
   git checkout ${BRANCH}
}
addtask do_checkout before do_compile after do_unpack


do_compile() {
   make \
   ALLOWED_IFACES="Port1:Port2" \
   SAMPLE_PERIOD_US=1000 \
   CFLAGS_EXTRA="${CFLAGS}"
}

do_install() {
   install -d ${D}/usr/bin/
   install -m 0744 ${S}/server/jt-server ${D}/usr/bin/

   install -d ${D}/var/lib/jittertrap/
   install -d ${D}/var/lib/jittertrap/fonts
   install -d ${D}/var/lib/jittertrap/css
   install -d ${D}/var/lib/jittertrap/js
   install -d ${D}/var/lib/jittertrap/templates
   install -m 0644 ${S}/html5-client/output/fonts/* ${D}/var/lib/jittertrap/fonts/
   install -m 0644 ${S}/html5-client/output/css/* ${D}/var/lib/jittertrap/css/
   install -m 0644 ${S}/html5-client/output/js/* ${D}/var/lib/jittertrap/js/
   install -m 0644 ${S}/html5-client/output/templates/* ${D}/var/lib/jittertrap/templates/
   install -m 0644 ${S}/html5-client/output/index.html ${D}/var/lib/jittertrap/

   install -d ${D}${systemd_unitdir}/system
   install -m 0644 ${WORKDIR}/jittertrap.service ${D}${systemd_unitdir}/system
   sed -i -e 's,@BINDIR@,${bindir},g' ${D}${systemd_unitdir}/system/jittertrap.service
}

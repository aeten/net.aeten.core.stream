SOURCE_VERSION = 1.7
JFLAGS ?= -g:source,lines,vars -encoding utf8
PROCESSOR_FACTORIES_MODULES ?= net.aeten.core
TOUCH_DIR = .touch


all: compile jar eclipse src test

# Sources
SRC = stream
src: $(SRC)
stream:: aeten.core

# COTS
COTS = aeten.core jcip.annotations slf4j
cots: $(COTS)
aeten.core::       jcip.annotations slf4j
jcip.annotations::
slf4j::

# Tests
TEST = stream.test
test: $(TEST)
stream.test:: stream

clean:
	$(RM) -rf $(BUILD_DIR) $(DIST_DIR) $(GENERATED_DIR) $(TOUCH_DIR)

SRC_DIRS = src/ test/
MODULES = $(SRC) $(COTS) $(TEST)
include Java-make/java.mk


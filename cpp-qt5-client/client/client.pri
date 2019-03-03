QT += network

HEADERS += \
# Models
    $${PWD}/OAICategory.h \
# APIs
    $${PWD}/OAICategoryApi.h \
    $${PWD}/OAIProductApi.h \
# Others
    $${PWD}/OAIHelpers.h \
    $${PWD}/OAIHttpRequest.h \
    $${PWD}/OAIObject.h

SOURCES += \
# Models
    $${PWD}/OAICategory.cpp \
# APIs
    $${PWD}/OAICategoryApi.cpp \
    $${PWD}/OAIProductApi.cpp \
# Others
    $${PWD}/OAIHelpers.cpp \
    $${PWD}/OAIHttpRequest.cpp


package ec.gob.snap.vuv.service;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import ec.gob.snap.vuv.model.Act_InstitucionalClp;
import ec.gob.snap.vuv.model.CasoClp;
import ec.gob.snap.vuv.model.CentroClp;
import ec.gob.snap.vuv.model.IndicadorClp;
import ec.gob.snap.vuv.model.InstitucionClp;
import ec.gob.snap.vuv.model.PasoClp;
import ec.gob.snap.vuv.model.RequisitoClp;
import ec.gob.snap.vuv.model.ServicioClp;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;


public class ClpSerializer {
    private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
    private static String _servletContextName;
    private static boolean _useReflectionToTranslateThrowable = true;

    public static String getServletContextName() {
        if (Validator.isNotNull(_servletContextName)) {
            return _servletContextName;
        }

        synchronized (ClpSerializer.class) {
            if (Validator.isNotNull(_servletContextName)) {
                return _servletContextName;
            }

            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Class<?> portletPropsClass = classLoader.loadClass(
                        "com.liferay.util.portlet.PortletProps");

                Method getMethod = portletPropsClass.getMethod("get",
                        new Class<?>[] { String.class });

                String portletPropsServletContextName = (String) getMethod.invoke(null,
                        "vuv-gpr-portlet-deployment-context");

                if (Validator.isNotNull(portletPropsServletContextName)) {
                    _servletContextName = portletPropsServletContextName;
                }
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info(
                        "Unable to locate deployment context from portlet properties");
                }
            }

            if (Validator.isNull(_servletContextName)) {
                try {
                    String propsUtilServletContextName = PropsUtil.get(
                            "vuv-gpr-portlet-deployment-context");

                    if (Validator.isNotNull(propsUtilServletContextName)) {
                        _servletContextName = propsUtilServletContextName;
                    }
                } catch (Throwable t) {
                    if (_log.isInfoEnabled()) {
                        _log.info(
                            "Unable to locate deployment context from portal properties");
                    }
                }
            }

            if (Validator.isNull(_servletContextName)) {
                _servletContextName = "vuv-gpr-portlet";
            }

            return _servletContextName;
        }
    }

    public static Object translateInput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(Act_InstitucionalClp.class.getName())) {
            return translateInputAct_Institucional(oldModel);
        }

        if (oldModelClassName.equals(CasoClp.class.getName())) {
            return translateInputCaso(oldModel);
        }

        if (oldModelClassName.equals(CentroClp.class.getName())) {
            return translateInputCentro(oldModel);
        }

        if (oldModelClassName.equals(IndicadorClp.class.getName())) {
            return translateInputIndicador(oldModel);
        }

        if (oldModelClassName.equals(InstitucionClp.class.getName())) {
            return translateInputInstitucion(oldModel);
        }

        if (oldModelClassName.equals(PasoClp.class.getName())) {
            return translateInputPaso(oldModel);
        }

        if (oldModelClassName.equals(RequisitoClp.class.getName())) {
            return translateInputRequisito(oldModel);
        }

        if (oldModelClassName.equals(ServicioClp.class.getName())) {
            return translateInputServicio(oldModel);
        }

        return oldModel;
    }

    public static Object translateInput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateInput(curObj));
        }

        return newList;
    }

    public static Object translateInputAct_Institucional(BaseModel<?> oldModel) {
        Act_InstitucionalClp oldClpModel = (Act_InstitucionalClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getAct_InstitucionalRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCaso(BaseModel<?> oldModel) {
        CasoClp oldClpModel = (CasoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCasoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputCentro(BaseModel<?> oldModel) {
        CentroClp oldClpModel = (CentroClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getCentroRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputIndicador(BaseModel<?> oldModel) {
        IndicadorClp oldClpModel = (IndicadorClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getIndicadorRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputInstitucion(BaseModel<?> oldModel) {
        InstitucionClp oldClpModel = (InstitucionClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getInstitucionRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputPaso(BaseModel<?> oldModel) {
        PasoClp oldClpModel = (PasoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getPasoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputRequisito(BaseModel<?> oldModel) {
        RequisitoClp oldClpModel = (RequisitoClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getRequisitoRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInputServicio(BaseModel<?> oldModel) {
        ServicioClp oldClpModel = (ServicioClp) oldModel;

        BaseModel<?> newModel = oldClpModel.getServicioRemoteModel();

        newModel.setModelAttributes(oldClpModel.getModelAttributes());

        return newModel;
    }

    public static Object translateInput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateInput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateInput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Object translateOutput(BaseModel<?> oldModel) {
        Class<?> oldModelClass = oldModel.getClass();

        String oldModelClassName = oldModelClass.getName();

        if (oldModelClassName.equals(
                    "ec.gob.snap.vuv.model.impl.Act_InstitucionalImpl")) {
            return translateOutputAct_Institucional(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.CasoImpl")) {
            return translateOutputCaso(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.CentroImpl")) {
            return translateOutputCentro(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.IndicadorImpl")) {
            return translateOutputIndicador(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals(
                    "ec.gob.snap.vuv.model.impl.InstitucionImpl")) {
            return translateOutputInstitucion(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.PasoImpl")) {
            return translateOutputPaso(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.RequisitoImpl")) {
            return translateOutputRequisito(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        if (oldModelClassName.equals("ec.gob.snap.vuv.model.impl.ServicioImpl")) {
            return translateOutputServicio(oldModel);
        } else if (oldModelClassName.endsWith("Clp")) {
            try {
                ClassLoader classLoader = ClpSerializer.class.getClassLoader();

                Method getClpSerializerClassMethod = oldModelClass.getMethod(
                        "getClpSerializerClass");

                Class<?> oldClpSerializerClass = (Class<?>) getClpSerializerClassMethod.invoke(oldModel);

                Class<?> newClpSerializerClass = classLoader.loadClass(oldClpSerializerClass.getName());

                Method translateOutputMethod = newClpSerializerClass.getMethod("translateOutput",
                        BaseModel.class);

                Class<?> oldModelModelClass = oldModel.getModelClass();

                Method getRemoteModelMethod = oldModelClass.getMethod("get" +
                        oldModelModelClass.getSimpleName() + "RemoteModel");

                Object oldRemoteModel = getRemoteModelMethod.invoke(oldModel);

                BaseModel<?> newModel = (BaseModel<?>) translateOutputMethod.invoke(null,
                        oldRemoteModel);

                return newModel;
            } catch (Throwable t) {
                if (_log.isInfoEnabled()) {
                    _log.info("Unable to translate " + oldModelClassName, t);
                }
            }
        }

        return oldModel;
    }

    public static Object translateOutput(List<Object> oldList) {
        List<Object> newList = new ArrayList<Object>(oldList.size());

        for (int i = 0; i < oldList.size(); i++) {
            Object curObj = oldList.get(i);

            newList.add(translateOutput(curObj));
        }

        return newList;
    }

    public static Object translateOutput(Object obj) {
        if (obj instanceof BaseModel<?>) {
            return translateOutput((BaseModel<?>) obj);
        } else if (obj instanceof List<?>) {
            return translateOutput((List<Object>) obj);
        } else {
            return obj;
        }
    }

    public static Throwable translateThrowable(Throwable throwable) {
        if (_useReflectionToTranslateThrowable) {
            try {
                UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

                objectOutputStream.writeObject(throwable);

                objectOutputStream.flush();
                objectOutputStream.close();

                UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
                        0, unsyncByteArrayOutputStream.size());

                Thread currentThread = Thread.currentThread();

                ClassLoader contextClassLoader = currentThread.getContextClassLoader();

                ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
                        contextClassLoader);

                throwable = (Throwable) objectInputStream.readObject();

                objectInputStream.close();

                return throwable;
            } catch (SecurityException se) {
                if (_log.isInfoEnabled()) {
                    _log.info("Do not use reflection to translate throwable");
                }

                _useReflectionToTranslateThrowable = false;
            } catch (Throwable throwable2) {
                _log.error(throwable2, throwable2);

                return throwable2;
            }
        }

        Class<?> clazz = throwable.getClass();

        String className = clazz.getName();

        if (className.equals(PortalException.class.getName())) {
            return new PortalException();
        }

        if (className.equals(SystemException.class.getName())) {
            return new SystemException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchAct_InstitucionalException")) {
            return new ec.gob.snap.vuv.NoSuchAct_InstitucionalException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchCasoException")) {
            return new ec.gob.snap.vuv.NoSuchCasoException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchCentroException")) {
            return new ec.gob.snap.vuv.NoSuchCentroException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchIndicadorException")) {
            return new ec.gob.snap.vuv.NoSuchIndicadorException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchInstitucionException")) {
            return new ec.gob.snap.vuv.NoSuchInstitucionException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchPasoException")) {
            return new ec.gob.snap.vuv.NoSuchPasoException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchRequisitoException")) {
            return new ec.gob.snap.vuv.NoSuchRequisitoException();
        }

        if (className.equals("ec.gob.snap.vuv.NoSuchServicioException")) {
            return new ec.gob.snap.vuv.NoSuchServicioException();
        }

        return throwable;
    }

    public static Object translateOutputAct_Institucional(BaseModel<?> oldModel) {
        Act_InstitucionalClp newModel = new Act_InstitucionalClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setAct_InstitucionalRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCaso(BaseModel<?> oldModel) {
        CasoClp newModel = new CasoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCasoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputCentro(BaseModel<?> oldModel) {
        CentroClp newModel = new CentroClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setCentroRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputIndicador(BaseModel<?> oldModel) {
        IndicadorClp newModel = new IndicadorClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setIndicadorRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputInstitucion(BaseModel<?> oldModel) {
        InstitucionClp newModel = new InstitucionClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setInstitucionRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputPaso(BaseModel<?> oldModel) {
        PasoClp newModel = new PasoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setPasoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputRequisito(BaseModel<?> oldModel) {
        RequisitoClp newModel = new RequisitoClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setRequisitoRemoteModel(oldModel);

        return newModel;
    }

    public static Object translateOutputServicio(BaseModel<?> oldModel) {
        ServicioClp newModel = new ServicioClp();

        newModel.setModelAttributes(oldModel.getModelAttributes());

        newModel.setServicioRemoteModel(oldModel);

        return newModel;
    }
}

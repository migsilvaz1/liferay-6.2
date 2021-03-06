package ec.gob.snap.vuv.service.base;

import ec.gob.snap.vuv.service.Act_InstitucionalLocalServiceUtil;

import java.util.Arrays;

/**
 * @author Brian Wing Shun Chan
 * @generated
 */
public class Act_InstitucionalLocalServiceClpInvoker {
    private String _methodName0;
    private String[] _methodParameterTypes0;
    private String _methodName1;
    private String[] _methodParameterTypes1;
    private String _methodName2;
    private String[] _methodParameterTypes2;
    private String _methodName3;
    private String[] _methodParameterTypes3;
    private String _methodName4;
    private String[] _methodParameterTypes4;
    private String _methodName5;
    private String[] _methodParameterTypes5;
    private String _methodName6;
    private String[] _methodParameterTypes6;
    private String _methodName7;
    private String[] _methodParameterTypes7;
    private String _methodName8;
    private String[] _methodParameterTypes8;
    private String _methodName9;
    private String[] _methodParameterTypes9;
    private String _methodName10;
    private String[] _methodParameterTypes10;
    private String _methodName11;
    private String[] _methodParameterTypes11;
    private String _methodName12;
    private String[] _methodParameterTypes12;
    private String _methodName13;
    private String[] _methodParameterTypes13;
    private String _methodName14;
    private String[] _methodParameterTypes14;
    private String _methodName15;
    private String[] _methodParameterTypes15;
    private String _methodName60;
    private String[] _methodParameterTypes60;
    private String _methodName61;
    private String[] _methodParameterTypes61;
    private String _methodName66;
    private String[] _methodParameterTypes66;
    private String _methodName67;
    private String[] _methodParameterTypes67;
    private String _methodName68;
    private String[] _methodParameterTypes68;
    private String _methodName69;
    private String[] _methodParameterTypes69;
    private String _methodName70;
    private String[] _methodParameterTypes70;
    private String _methodName71;
    private String[] _methodParameterTypes71;

    public Act_InstitucionalLocalServiceClpInvoker() {
        _methodName0 = "addAct_Institucional";

        _methodParameterTypes0 = new String[] {
                "ec.gob.snap.vuv.model.Act_Institucional"
            };

        _methodName1 = "createAct_Institucional";

        _methodParameterTypes1 = new String[] { "long" };

        _methodName2 = "deleteAct_Institucional";

        _methodParameterTypes2 = new String[] { "long" };

        _methodName3 = "deleteAct_Institucional";

        _methodParameterTypes3 = new String[] {
                "ec.gob.snap.vuv.model.Act_Institucional"
            };

        _methodName4 = "dynamicQuery";

        _methodParameterTypes4 = new String[] {  };

        _methodName5 = "dynamicQuery";

        _methodParameterTypes5 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName6 = "dynamicQuery";

        _methodParameterTypes6 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int"
            };

        _methodName7 = "dynamicQuery";

        _methodParameterTypes7 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery", "int", "int",
                "com.liferay.portal.kernel.util.OrderByComparator"
            };

        _methodName8 = "dynamicQueryCount";

        _methodParameterTypes8 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery"
            };

        _methodName9 = "dynamicQueryCount";

        _methodParameterTypes9 = new String[] {
                "com.liferay.portal.kernel.dao.orm.DynamicQuery",
                "com.liferay.portal.kernel.dao.orm.Projection"
            };

        _methodName10 = "fetchAct_Institucional";

        _methodParameterTypes10 = new String[] { "long" };

        _methodName11 = "getAct_Institucional";

        _methodParameterTypes11 = new String[] { "long" };

        _methodName12 = "getPersistedModel";

        _methodParameterTypes12 = new String[] { "java.io.Serializable" };

        _methodName13 = "getAct_Institucionals";

        _methodParameterTypes13 = new String[] { "int", "int" };

        _methodName14 = "getAct_InstitucionalsCount";

        _methodParameterTypes14 = new String[] {  };

        _methodName15 = "updateAct_Institucional";

        _methodParameterTypes15 = new String[] {
                "ec.gob.snap.vuv.model.Act_Institucional"
            };

        _methodName60 = "getBeanIdentifier";

        _methodParameterTypes60 = new String[] {  };

        _methodName61 = "setBeanIdentifier";

        _methodParameterTypes61 = new String[] { "java.lang.String" };

        _methodName66 = "addAct_Institucional";

        _methodParameterTypes66 = new String[] { "long", "long", "java.util.Date" };

        _methodName67 = "addAct_Institucional";

        _methodParameterTypes67 = new String[] {
                "long", "long", "java.util.Date", "long"
            };

        _methodName68 = "deleteAct_Institucional";

        _methodParameterTypes68 = new String[] { "long" };

        _methodName69 = "updateAct_Institucional";

        _methodParameterTypes69 = new String[] {
                "ec.gob.snap.vuv.model.Act_Institucional"
            };

        _methodName70 = "getAllAct_Institucionales";

        _methodParameterTypes70 = new String[] {  };

        _methodName71 = "getAct_InstitucionalBygprId";

        _methodParameterTypes71 = new String[] { "long" };
    }

    public Object invokeMethod(String name, String[] parameterTypes,
        Object[] arguments) throws Throwable {
        if (_methodName0.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes0, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.addAct_Institucional((ec.gob.snap.vuv.model.Act_Institucional) arguments[0]);
        }

        if (_methodName1.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes1, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.createAct_Institucional(((Long) arguments[0]).longValue());
        }

        if (_methodName2.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes2, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.deleteAct_Institucional(((Long) arguments[0]).longValue());
        }

        if (_methodName3.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes3, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.deleteAct_Institucional((ec.gob.snap.vuv.model.Act_Institucional) arguments[0]);
        }

        if (_methodName4.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes4, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQuery();
        }

        if (_methodName5.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes5, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName6.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes6, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue());
        }

        if (_methodName7.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes7, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQuery((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                ((Integer) arguments[1]).intValue(),
                ((Integer) arguments[2]).intValue(),
                (com.liferay.portal.kernel.util.OrderByComparator) arguments[3]);
        }

        if (_methodName8.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes8, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0]);
        }

        if (_methodName9.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes9, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.dynamicQueryCount((com.liferay.portal.kernel.dao.orm.DynamicQuery) arguments[0],
                (com.liferay.portal.kernel.dao.orm.Projection) arguments[1]);
        }

        if (_methodName10.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes10, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.fetchAct_Institucional(((Long) arguments[0]).longValue());
        }

        if (_methodName11.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes11, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getAct_Institucional(((Long) arguments[0]).longValue());
        }

        if (_methodName12.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes12, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getPersistedModel((java.io.Serializable) arguments[0]);
        }

        if (_methodName13.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes13, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getAct_Institucionals(((Integer) arguments[0]).intValue(),
                ((Integer) arguments[1]).intValue());
        }

        if (_methodName14.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes14, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getAct_InstitucionalsCount();
        }

        if (_methodName15.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes15, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.updateAct_Institucional((ec.gob.snap.vuv.model.Act_Institucional) arguments[0]);
        }

        if (_methodName60.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes60, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getBeanIdentifier();
        }

        if (_methodName61.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes61, parameterTypes)) {
            Act_InstitucionalLocalServiceUtil.setBeanIdentifier((java.lang.String) arguments[0]);

            return null;
        }

        if (_methodName66.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes66, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.addAct_Institucional(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(), (java.util.Date) arguments[2]);
        }

        if (_methodName67.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes67, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.addAct_Institucional(((Long) arguments[0]).longValue(),
                ((Long) arguments[1]).longValue(),
                (java.util.Date) arguments[2], ((Long) arguments[3]).longValue());
        }

        if (_methodName68.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes68, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.deleteAct_Institucional(((Long) arguments[0]).longValue());
        }

        if (_methodName69.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes69, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.updateAct_Institucional((ec.gob.snap.vuv.model.Act_Institucional) arguments[0]);
        }

        if (_methodName70.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes70, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getAllAct_Institucionales();
        }

        if (_methodName71.equals(name) &&
                Arrays.deepEquals(_methodParameterTypes71, parameterTypes)) {
            return Act_InstitucionalLocalServiceUtil.getAct_InstitucionalBygprId(((Long) arguments[0]).longValue());
        }

        throw new UnsupportedOperationException();
    }
}

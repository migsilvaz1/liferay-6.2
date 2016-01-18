package ec.gob.snap.vuv.service.persistence;

import com.liferay.portal.service.persistence.BasePersistence;

import ec.gob.snap.vuv.model.Requisito;

/**
 * The persistence interface for the requisito service.
 *
 * <p>
 * Caching information and settings can be found in <code>portal.properties</code>
 * </p>
 *
 * @author Brian Wing Shun Chan
 * @see RequisitoPersistenceImpl
 * @see RequisitoUtil
 * @generated
 */
public interface RequisitoPersistence extends BasePersistence<Requisito> {
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never modify or reference this interface directly. Always use {@link RequisitoUtil} to access the requisito persistence. Modify <code>service.xml</code> and rerun ServiceBuilder to regenerate this interface.
     */

    /**
    * Caches the requisito in the entity cache if it is enabled.
    *
    * @param requisito the requisito
    */
    public void cacheResult(ec.gob.snap.vuv.model.Requisito requisito);

    /**
    * Caches the requisitos in the entity cache if it is enabled.
    *
    * @param requisitos the requisitos
    */
    public void cacheResult(
        java.util.List<ec.gob.snap.vuv.model.Requisito> requisitos);

    /**
    * Creates a new requisito with the primary key. Does not add the requisito to the database.
    *
    * @param id_requisito the primary key for the new requisito
    * @return the new requisito
    */
    public ec.gob.snap.vuv.model.Requisito create(long id_requisito);

    /**
    * Removes the requisito with the primary key from the database. Also notifies the appropriate model listeners.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito that was removed
    * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Requisito remove(long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchRequisitoException;

    public ec.gob.snap.vuv.model.Requisito updateImpl(
        ec.gob.snap.vuv.model.Requisito requisito)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the requisito with the primary key or throws a {@link ec.gob.snap.vuv.NoSuchRequisitoException} if it could not be found.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito
    * @throws ec.gob.snap.vuv.NoSuchRequisitoException if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Requisito findByPrimaryKey(long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException,
            ec.gob.snap.vuv.NoSuchRequisitoException;

    /**
    * Returns the requisito with the primary key or returns <code>null</code> if it could not be found.
    *
    * @param id_requisito the primary key of the requisito
    * @return the requisito, or <code>null</code> if a requisito with the primary key could not be found
    * @throws SystemException if a system exception occurred
    */
    public ec.gob.snap.vuv.model.Requisito fetchByPrimaryKey(long id_requisito)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns all the requisitos.
    *
    * @return the requisitos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Requisito> findAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns a range of all the requisitos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requisitos
    * @param end the upper bound of the range of requisitos (not inclusive)
    * @return the range of requisitos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Requisito> findAll(int start,
        int end) throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns an ordered range of all the requisitos.
    *
    * <p>
    * Useful when paginating results. Returns a maximum of <code>end - start</code> instances. <code>start</code> and <code>end</code> are not primary keys, they are indexes in the result set. Thus, <code>0</code> refers to the first result in the set. Setting both <code>start</code> and <code>end</code> to {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS} will return the full result set. If <code>orderByComparator</code> is specified, then the query will include the given ORDER BY logic. If <code>orderByComparator</code> is absent and pagination is required (<code>start</code> and <code>end</code> are not {@link com.liferay.portal.kernel.dao.orm.QueryUtil#ALL_POS}), then the query will include the default ORDER BY logic from {@link ec.gob.snap.vuv.model.impl.RequisitoModelImpl}. If both <code>orderByComparator</code> and pagination are absent, for performance reasons, the query will not have an ORDER BY clause and the returned result set will be sorted on by the primary key in an ascending order.
    * </p>
    *
    * @param start the lower bound of the range of requisitos
    * @param end the upper bound of the range of requisitos (not inclusive)
    * @param orderByComparator the comparator to order the results by (optionally <code>null</code>)
    * @return the ordered range of requisitos
    * @throws SystemException if a system exception occurred
    */
    public java.util.List<ec.gob.snap.vuv.model.Requisito> findAll(int start,
        int end,
        com.liferay.portal.kernel.util.OrderByComparator orderByComparator)
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Removes all the requisitos from the database.
    *
    * @throws SystemException if a system exception occurred
    */
    public void removeAll()
        throws com.liferay.portal.kernel.exception.SystemException;

    /**
    * Returns the number of requisitos.
    *
    * @return the number of requisitos
    * @throws SystemException if a system exception occurred
    */
    public int countAll()
        throws com.liferay.portal.kernel.exception.SystemException;
}

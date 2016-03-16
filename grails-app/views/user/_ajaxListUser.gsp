<g:each in="${users}" var="user">

    <g:if test="${user.isActive}">
        <tr class="alert-success">
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email_id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><g:if test="${users.isActive}">Yes</g:if><g:else>No</g:else></td>
            <td><my:activateDeacivate id="${user.id}"/></td>
        </tr>
    </g:if>
    <g:else>
        <tr class="alert-danger">
            <td>${user.id}</td>
            <td>${user.userName}</td>
            <td>${user.email_id}</td>
            <td>${user.firstName}</td>
            <td>${user.lastName}</td>
            <td><g:if test="${user.isActive}">Yes</g:if><g:else>No</g:else></td>
            <td style="cursor: pointer;"><my:activateDeacivate id="${user.id}"/></td>
        </tr>

    </g:else>

</g:each>
<div class="panel-body">

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>Id</th>
            <th>UserName</th>
            <th>Email</th>
            <th>FirstName</th>
            <th>LastName</th>
            <th>Active</th>
            <th>Manage</th>
        </tr>
        </thead>
        <tbody>
        <div class="myUser">
        <g:render template="/user/ajaxListUser" model="[users:users]"/>
       </div>
        </tbody>
    </table>

</div>

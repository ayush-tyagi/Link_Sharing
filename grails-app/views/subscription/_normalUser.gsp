<div class="row-fluid">
    %{--<a href="${createLink(controller: 'subscription', action: 'save', params: [topicId: topicId])}">Subscribe</a>--}%
    <g:link name="${topicId}" data-id="${topicId}" onclick="subscribe(${topicId});">Subscribe</g:link>
</div>
